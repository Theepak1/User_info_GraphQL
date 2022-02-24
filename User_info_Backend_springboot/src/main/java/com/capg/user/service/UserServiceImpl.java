package com.capg.user.service;
//
//
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.capg.user.bean.User;
import com.capg.user.mapstruct.dto.UserDTO;
import com.capg.user.mapstruct.mapper.IUserMapper;
import com.capg.user.repository.IUserRepository;


import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.TypeDefinitionRegistry;
import graphql.schema.idl.SchemaParser;

@Service("service")
public class UserServiceImpl implements IUserService {
	
	@Value("classpath:users.graphql")
    Resource resource;

	@Autowired
	IUserRepository repo;
	
	@Autowired
	IUserMapper map;
	
	@Override
	public UserDTO addUser(User user) {
		User result = repo.save(user);
		UserDTO userDTO = map.UserToUserDTO(result);
		return userDTO;
	}

	public List<User> getAllUsers() {
		List<User> result = repo.findAll();
		return result;
	}
	

    private GraphQL graphQL;
    @Autowired
    private AllUsersDataFetcher allUsersDataFetcher;
    @Autowired
    private UserDataFetcher userDataFetcher;

    // load schema at application start up
    @PostConstruct
    private void loadSchema() throws IOException {

        // get the schema
        File schemaFile = resource.getFile();
        // parse schema
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemaFile);
        RuntimeWiring wiring = buildRuntimeWiring();
        GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
        graphQL = GraphQL.newGraphQL(schema).build();
    }
	
    
    private RuntimeWiring buildRuntimeWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type("Query", typeWiring -> typeWiring
                        .dataFetcher("allUsers", allUsersDataFetcher)
                        .dataFetcher("user", userDataFetcher))
                .build();
    }
    
    public GraphQL getGraphQL() {
        return graphQL;
    }

	public void deleteUser(int id) {
		repo.deleteById(id);;
	
	}

	public UserDTO updateUser(User user) {
		User result = repo.save(user);
		UserDTO userDTO = map.UserToUserDTO(result);
		return userDTO;
	}

}
