/**
 * This parser uses YamlBeans APIs to parse the following configurations
 * 1. glue.yml : this file contains the specs for connecting to WFA server
 * 2. mapping.yml: this file contains the mapping between storage service and WFA workflows
 * YamlBeans automatically serializes the YAML data to beans
 * @author antani
 */
package com.netapp.glue.conf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import kwalify.*;

import org.yaml.snakeyaml.Yaml;

import com.esotericsoftware.yamlbeans.YamlException;
import com.esotericsoftware.yamlbeans.YamlReader;


public class ConfParser {
	public static ServerConf parseServerConf(){
		YamlReader reader=null;
		try {
			reader = new YamlReader(new FileReader("glue.yml"));
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		ServerConf serverConf=null;;
		try {
			serverConf = reader.read(ServerConf.class);
		} catch (YamlException e) {
			
			e.printStackTrace();
		}
		return serverConf;
	}
	
	//TODO
	//Generate classes using
	//http://www.kuwata-lab.com/kwalify/ruby/users-guide.04.html#actions
	public static MappingConf parseMappingConf(){
		YamlReader reader=null;
		try {
			reader = new YamlReader(new FileReader("servicemapping.yml"));
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		MappingConf mappingConf=null;
		try {
			mappingConf = reader.read(MappingConf.class);
		} catch (YamlException e) {
			
			e.printStackTrace();
		}

		return mappingConf;
	}	
	
	public static void genericParserOld(){
		
		    Yaml yaml = new Yaml();		
		    InputStream input=null;
			try {
				input = new FileInputStream(new File("servicemapping.yml"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
					
		    Object map = yaml.load(input);
		    System.out.println(map.toString());
		    Object obj = ConfParser.construct(map.toString());

		

	}
	public static void genericParser() throws IOException, SyntaxException{
		// read schema
        String schema_str = Util.readFile("servicemapping.schema.yml");
        schema_str = Util.untabify(schema_str);
        Object schema = new YamlParser(schema_str).parse();

        // read document file
        String document_str = Util.readFile("servicemapping.yml");
        document_str = Util.untabify(document_str);
        YamlParser parser = new YamlParser(document_str);
        Object document = parser.parse();
        // create ServiceMapping
        ServiceMapping serviceMapping = new ServiceMapping((Map)document);
        
	}
	public static void main(String[] args){
		try {
			genericParser();
		} catch (SyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static Object construct(String data) {
        Yaml yaml = new Yaml();
        return yaml.load(data);
    }

	

}
