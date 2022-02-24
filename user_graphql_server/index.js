const {ApolloServer} = require('apollo-server');
const UserAPI = require('./dataSources/user')

const typeDefs = require('./schema')
const resolvers = require('./resolvers') 

const dataSources = () => ({
    UserAPI : new UserAPI()
});

const server = new ApolloServer({typeDefs,resolvers,dataSources});

server
    .listen({port:4000})
    .then(({url}) => {
        console.log(`server running at ${url}`);
    })