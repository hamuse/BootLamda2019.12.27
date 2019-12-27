package com.hamuse.web.person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hamuse.web.util.Printer;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
public class PersonController {
	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private Printer printer;
	@Autowired
	private Person person;
	@Autowired
	ModelMapper modelMapper;
	@Bean public ModelMapper modelMapper() {return new ModelMapper();} //json 하고 교환할수 있게 해준다. 
	
	@RequestMapping("/")
	public String index() {
		Iterable<Person> all = personRepository.findAll();
		StringBuilder sb = new StringBuilder();
		all.forEach(p -> sb.append(p.getName()+" "));
		return sb.toString();
	}
	@PostMapping("/login")
	public HashMap<String,Object> login(@RequestBody Person person) {
		HashMap<String,Object> map = new HashMap<>();
		printer.accept("로그인 진입");
		printer.accept(String.format("USERID: %s", person.getUserid()));
		printer.accept(String.format("PASSWD: %s", person.getPasswd()));
		person = personRepository.findByUseridAndPasswd(
				person.getUserid(),
				person.getPasswd());
		if(person != null) {
			printer.accept("로그인성공");
			map.put("result", "SUCCESS");
			map.put("person",person);
		}else {
			map.put("result", "FAIL");
			map.put("person",person);
		}
		return map;
	}
	
	@PostMapping("/join")
	public HashMap<String,Object> join(@RequestBody Person person){
		HashMap<String,Object> map = new HashMap<>();
		/* DateFormat dateformat = new SimpleDateFormat(); */
		/*
		 * printer.accept("조인 컨트롤러 진입"); printer.accept(person.getUserid());
		 * printer.accept(person.getPasswd()); printer.accept(person.getName());
		 */
		/* printer.accept(person.getBirthday()); 불러왔을때 형식이 데이터 형식이라 아예 안불러 오던가 스트링 형식으로 바껴야 저장이된다. */
		/*
		 * String birthday = String.valueOf(person.getBirthday());
		 * printer.accept(birthday);
		 */
		
		personRepository.save(person);
		
		
		
		return map;
	}
	//userid,passwd,name,birthday
	
	@DeleteMapping("/withdrawal/{userid}")
	public void withdrawal(@PathVariable String userid) {
		/*
		 * printer.accept("withdrawal 컨트롤러 들어옴"); printer.accept(person.getUserid());
		 * printer.accept(person.getPasswd());
		 */
		/* personRepository.delete(person); */
		
		personRepository
		.delete(personRepository
				.findByUserid(userid));
	}
	@PostMapping("/update")
	public void update(@RequestBody Person person){
		
		/* DateFormat dateformat = new SimpleDateFormat(); */
		/*
		 * printer.accept("조인 컨트롤러 진입"); printer.accept(person.getUserid());
		 * printer.accept(person.getPasswd()); printer.accept(person.getName());
		 */
		/* printer.accept(person.getBirthday()); 불러왔을때 형식이 데이터 형식이라 아예 안불러 오던가 스트링 형식으로 바껴야 저장이된다. */
		/*
		 * String birthday = String.valueOf(person.getBirthday());
		 * printer.accept(birthday);
		 */
		
		printer.accept("update 컨트롤러"+person.getId()); 
		 personRepository.save(person);
		/* personRepository.save(param); */
		 	}
	@GetMapping("/students")
	public Stream<PersonDTO> list(){
		printer.accept("리스트 들어옴");
//		Iterable<Person> entites= personReopsitory.findByRole("student")
		Iterable<Person> entites = personRepository.findAll();
		List<PersonDTO> list = new ArrayList<>();
		for(Person p : entites) {
			PersonDTO dto = modelMapper.map(p, PersonDTO.class);
			list.add(dto);
		}
		printer.accept("list count"+list.size());
		return list.stream().filter(role->role.getRole().equals("student"));
	}
	@GetMapping("/students/{searchWord}")
	public Stream<PersonDTO> findSome(@PathVariable String searchWord){
		printer.accept("findSome 들어옴");
		switch(searchWord) {
		case "namesOfStudents": break;
		case "streamToArray": break;
		case "streamToMap": break;
		case "theNumberOfStudents": break;
		case "totalScore": break;
		case "topStudent": break;
		case "getStat": break;
		case "nameList": break;
		case "partioningBy": break;
		case "partioningCountPerGender": break;
		case "partioningTopPerGender": break;
		case "partioningRejectPerGender": break;
		case "groupingByBan": break;
		case "groupingByGrade": break;
		case "groupingByCountByLevel": break;
		case "groupingByHakAndBan": break;
		case "groupingTopByHakAndBan": break;
		case "groupingByStat": break;
		
		}
		/*
		 * // Iterable<Person> entites= personReopsitory.findByRole("student")
		 * Iterable<Person> entites = personRepository.findAll(); List<PersonDTO> list =
		 * new ArrayList<>(); for(Person p : entites) { PersonDTO dto =
		 * modelMapper.map(p, PersonDTO.class); list.add(dto); }
		 * printer.accept("list count"+list.size()); return
		 * list.stream().filter(role->role.getRole().equals("student"));
		 */
		return null;
	}
}
