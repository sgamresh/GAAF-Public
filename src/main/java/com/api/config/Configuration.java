package com.api.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadType;
import org.aeonbits.owner.Config.Key;
import org.aeonbits.owner.Config.LoadPolicy;
 

@LoadPolicy(LoadType.MERGE)
@Config.Sources({"system:properties", "classpath:res/api.properties"})
public interface Configuration extends Config{

	@Key("api.stg.uri.publicapis")
	String api_publicapis();
	
	@Key("api.stg.uri.joke")
	String api_joke();
	
	
}
