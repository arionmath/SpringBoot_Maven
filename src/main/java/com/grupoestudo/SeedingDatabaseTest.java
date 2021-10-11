package com.grupoestudo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.grupoestudo.models.GroupModel;
import com.grupoestudo.models.MemberModel;
import com.grupoestudo.repositories.GroupRepositorie;
import com.grupoestudo.repositories.MemberRepositorie;
@Component
@Profile("test")
public class SeedingDatabaseTest implements CommandLineRunner {
	@Autowired
	GroupRepositorie GP;
	@Autowired
	MemberRepositorie MR;

	@Override
	public void run(String... args) throws Exception {
		
		GroupModel a1 = new GroupModel(null, "Phisical", "www.discord.com", false, null);
		GroupModel a2 = new GroupModel(null, "Chemical", "www.discord.com", false, null);
		GroupModel a3 = new GroupModel(null, "Biology", "www.discord.com", false, null);
		
		MemberModel b = new MemberModel(null, "ze", "9999999", a1);
		MemberModel c = new MemberModel(null, "joca", "1234999", a1);
		MemberModel d = new MemberModel(null, "joao", "4321999", a1);
		MemberModel e = new MemberModel(null, "camila", "5678999", a2);
		MemberModel f = new MemberModel(null, "maria", "8765999", a2);
		MemberModel g = new MemberModel(null, "mateus", "3546399", a3);
		MemberModel h = new MemberModel(null, "Goku", "9993429", a3);
		
		GP.saveAll(Arrays.asList(a1,a2,a3));
		
		MR.saveAll(Arrays.asList(b,c,d,e,f,g,h));
		
	}

}
