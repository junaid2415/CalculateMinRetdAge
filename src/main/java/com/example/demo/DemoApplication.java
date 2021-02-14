package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@RestController
	@CrossOrigin(origins = "http://localhost:4200")
	public static class Controller {

		@GetMapping("/hi")
		public String sayHi(){
			return "Hiii";
		}

		@GetMapping("/minAge/{age}/{income}/{expenses}")
		public int getMIn(@PathVariable int age, @PathVariable int income, @PathVariable int expenses){

			double tsav;
			double sal;
			double exp;
			int salFIx;
			int expFix;
			int ans=0;
			int lo,hi,retd;

			salFIx = income;
			expFix=expenses;
			tsav = salFIx-expFix;

			lo=age;
			hi = 85;

			while (lo<=hi){
				retd = (int) Math.ceil((lo+hi)/2);
				if(retd == lo){
					break;
				}
				System.out.print(lo);
				System.out.print(hi);
				System.out.print(retd);
				System.out.println(" ");

				tsav=salFIx-expFix;
				sal=salFIx;
				exp=expFix;

				for(int i=0;i< (retd-age); i++){
					tsav=tsav*(1.1);
					sal=sal*(1.06);
					exp=exp* 1.06;
					tsav=tsav+(sal-exp);
				}

				for (int i=0; i< (85-retd); i++){
					exp= exp*1.06;
					tsav = tsav-exp;
					tsav = tsav*(1.1);
				}
				if(tsav>0){
					ans = retd;
					hi = retd;
				}
				else {
					lo=retd;
				}
			}

			System.out.println(ans);
			return ans+1;
		}
	}
}
