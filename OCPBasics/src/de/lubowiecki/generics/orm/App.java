package de.lubowiecki.generics.orm;

import java.util.ArrayList;
import java.util.List;

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
		
		System.out.println("-------------");
		
		// RawType: Object
		List list = new ArrayList();
		list.add(null); // nimmt Object entgegen
		list.get(0); // liefert Object
		
		List<String> list2 = new ArrayList<>();
		list.add((String) null); // Bei Generics setzt der Kompiler an passender Stelle Type-Casts ein
		String s = (String) list.get(0); // Bei Generics setzt der Kompiler an passender Stelle Type-Casts ein
		
	}

}
