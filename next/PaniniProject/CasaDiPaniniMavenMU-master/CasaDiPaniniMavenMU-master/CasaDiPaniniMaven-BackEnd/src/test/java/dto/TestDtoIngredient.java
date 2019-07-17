package dto;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.apps.dto.IngredientDTO;
import com.apps.facade.IFacade;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:META-INF/spring-conf.xml")
@Transactional
public class TestDtoIngredient {

	@Autowired
	IFacade	facade;
	
	@Test
	@Rollback(true)
	public void ajoutIngredient() {
		IngredientDTO ingredientDTO = new IngredientDTO();
		ingredientDTO.setReferenceIngredient("bacon");
		facade.getServiceIngredient().save(ingredientDTO);
		
		Assert.assertEquals(1, facade.getServiceIngredient().getAll().size());
	}
	
	@Test
	@Rollback(true)
	public void update() {
		IngredientDTO ingredientDTO = new IngredientDTO();
		ingredientDTO.setReferenceIngredient("bacon");
		ingredientDTO.setNomIngredient("bacon americain");
		facade.getServiceIngredient().save(ingredientDTO);
		
		ingredientDTO = facade.getServiceIngredient().get("bacon");
		System.out.println(ingredientDTO.getIngredientID());
		ingredientDTO.setNomIngredient("bacon");
		
		facade.getServiceIngredient().update(ingredientDTO);
		
		IngredientDTO ingredientDTOToFind = facade.getServiceIngredient().get("bacon");
		Assert.assertEquals("bacon", ingredientDTOToFind.getNomIngredient());
	}
	
	@Test
	@Rollback(true)
	public void getAll() {
		for(int i=0; i<5; i++) {
			IngredientDTO ingredientDTO = new IngredientDTO();
			ingredientDTO.setNomIngredient("ingredient "+i);
			ingredientDTO.setReferenceIngredient("ref "+i);
			ingredientDTO.setNomImageIngredient("bacon.PNG");
			facade.getServiceIngredient().save(ingredientDTO);
		}
		
		for(IngredientDTO ingredientDTOList : facade.getServiceIngredient().getAll())
			System.out.println(" ingredient : [ "+ingredientDTOList.getNomIngredient()+"]");
	}
}