package com.example.demo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	
	@RequestMapping("/")
	public String sayHello() {
		return "Welcome to SpringBoot...";
	}
	
	@RequestMapping("/keerthana")
	public String keerthana()
	{
		return "Hi I am Keerthana";
	}
	
	@RequestMapping("/saranya")
	public String saranya()
	{
		return "Hi I am Saranya";
	}
	
	@RequestMapping("/akshaya")
	public String akshaya()
	{
		return "Hi I am Akshaya";
	}
 
	@RequestMapping("/greet/{name}")
	public String greeting(@PathVariable String name)
	{
		return "Good Evening to " +name;
	}
	
	@RequestMapping("/sum/{a}/{b}")
	public String sum(@PathVariable int a, @PathVariable int b)
	{
		int c=a+b;
		String res="";
		res+=c;
		return res;
		
	}
	
	@RequestMapping("/sub/{a}/{b}")
	public String sub(@PathVariable int a, @PathVariable int b)
	{
		int c= a-b;
		String res="";
		res+=c;
		return res;
	}
	
	@RequestMapping("/mul/{a}/{b}")
	public String mul(@PathVariable int a, @PathVariable int b)
	{
		int c= a*b;
		String res="";
		res+=c;
		return res;
	}
	
	@RequestMapping("/div/{a}/{b}")
	public String div(@PathVariable int a, @PathVariable int b)
	{
		int c= a/b;
		String res="";
		res+=c;
		return res;
	}
	
}
