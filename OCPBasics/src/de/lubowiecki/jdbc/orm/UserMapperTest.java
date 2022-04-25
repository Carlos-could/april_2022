package de.lubowiecki.jdbc.orm;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class UserMapperTest {
	
	static UserMapper mapper;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		mapper = new UserMapper();
	}

	@Test
	void testInsert() {
		User u = new User();
		u.setFirstname("Peter");
		u.setLastname("Parker");
		try {
			mapper.insert(u);
			assertTrue((u.getId() > 0));
		}
		catch(Exception e) {
			//...
		}
	}
	
	@Test
	void testUpdate() {
		
		try {
			Optional<User> uo = mapper.findById(5);
		
			if(uo.isPresent()) {
				uo.get().setFirstname("Hans");
				uo.get().setLastname("Hansen");
				mapper.update(uo.get());
			}
		
			uo = mapper.findById(5);
			assertEquals("Hans", uo.get().getFirstname());
			assertEquals("Hansen", uo.get().getLastname());
		}
		catch(Exception e) {
			//...
		}
	}

}
