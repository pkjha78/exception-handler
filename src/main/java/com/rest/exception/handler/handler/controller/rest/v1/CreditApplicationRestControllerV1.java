package com.rest.exception.handler.handler.controller.rest.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.exception.handler.handler.entity.CreditApplication;
import com.rest.exception.handler.handler.error.CreditApplicationAlreadyExistsException;
import com.rest.exception.handler.handler.error.CreditApplicationNotFoundException;
import com.rest.exception.handler.handler.repository.CreditApplicationRespository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/rest/v1")
@Api(value="Credit Management System")
public class CreditApplicationRestControllerV1 {

	@Autowired
	private CreditApplicationRespository creditAppRepo;
	
	
	/*@Autowired
	public RequestMappingHandlerMapping requestMappingHandlerMapping;
	
	@RequestMapping
	public @ResponseBody
	Object showEndpointsAction() throws SQLException {
		return requestMappingHandlerMapping.getHandlerMethods().keySet().stream().map(t ->
	        (t.getMethodsCondition().getMethods().size() == 0 ? "GET" : t.getMethodsCondition().getMethods().toArray()[0]) + " " +                    
	        t.getPatternsCondition().getPatterns().toArray()[0]
	    ).toArray();
	 }*/
		
	/*@PostMapping("/credits")
	public ResponseEntity<CreditApplication> addCredit(@RequestBody ProcessContainer processContainer, UriComponentsBuilder ucBuilder){
		Customer customer = processContainer.getCustomer();
		CreditApplication creditApplication = processContainer.getCreditApplication();
		creditApplication.setCustomerId(customer.getId());
		if(creditAppRepo.findById(creditApplication.getId()).isPresent()){
			throw new CreditApplicationAlreadyExistsException(creditApplication.getId());
		}
		creditAppRepo.save(creditApplication);
		HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/rest/v1/credits/{id}").buildAndExpand(creditApplication.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}*/
	
	@ApiOperation(value = "Add new Credit Application.", response = ResponseEntity.class)
	@ApiResponses(value = {
	    @ApiResponse(code = 201, message = "The request has been fulfilled and resulted in a new resource being created"),	    
	    @ApiResponse(code = 409, message = "The request could not be completed due to a conflict with the current state of resource")
	})
	@PostMapping("/credits")
	public ResponseEntity<CreditApplication> addCredit(@RequestBody CreditApplication creditApplication){
		/*try {
			creditAppRepo.save(creditApplication);
            return ResponseEntity.ok().build();
        }
        catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }*/
		
		if (creditAppRepo.findById(creditApplication.getCustomerId()).isPresent()) {
            throw new CreditApplicationAlreadyExistsException(creditApplication.getCustomerId());
        }
		creditAppRepo.save(creditApplication);
		return new ResponseEntity<>(HttpStatus.CREATED);	
	}
	
	
	@ApiOperation(value = "View a list of available creadits application", response = List.class)
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Successfully retrieved list"),
	    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@GetMapping("/credits")
	public ResponseEntity<List<CreditApplication>> getAllCredits(){
		return ResponseEntity.ok(creditAppRepo.findAll());
	}
	
	@ApiOperation(value = "View a available creadits application by id")
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Successfully retrieved list"),
	    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@GetMapping("/credits/{id}")
	public ResponseEntity<CreditApplication> getCreditsById(@PathVariable Long id){		
		return creditAppRepo.findById(id)
                .map(creditApplication -> new ResponseEntity<>(creditApplication, HttpStatus.OK))
                .orElseThrow(() -> new CreditApplicationNotFoundException(id));
	}
	
	/*@GetMapping("/mockdata")
	public CreditApplication addCreditApplicationMockData(){
		
		CreditApplication credApp = new CreditApplication();		
		SelfDisclosure selfDisclosure = new SelfDisclosure();
		
		Earnings earnings = new Earnings(10000, 2000, 1000);
		Outgoings outgoings = new Outgoings(2000,1000,3000);
		selfDisclosure.setEarnings(earnings);
		selfDisclosure.setOutgoings(outgoings);
		
		credApp.setSelfDisclosure(selfDisclosure);
		credApp.setAmount(new BigDecimal(20000));
		credApp.setCustomerId(new Long(1));
		credApp.setMonthlyPayment(new BigDecimal(5000));
		credApp.setPercentage(new BigDecimal(200));
		credApp.setTerm(1);
		credApp.setPurpose("Education");
		creditAppRepo.save(credApp);
		return credApp;
	}*/
}
