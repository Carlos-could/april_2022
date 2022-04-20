package de.lubowiecki.generics.orm;

public class App {

	public static void main(String[] args) {
		
		UserMapper mapper = new UserMapper();
		
		User u = new User();
		u.setFirstName("Peter");
		u.setLastName("Parker");
		
		mapper.insert(u);
		
		u.setLastName("Banner");
		mapper.update(u);
		
		ProductMapper pMapper = new ProductMapper();
		pMapper.insert(new Product());
		

	}

}
