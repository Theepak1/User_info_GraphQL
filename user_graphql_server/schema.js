const {gql} = require('apollo-server')

module.exports=gql`
type Query{
    users:[User]
},
type User {
    id:ID!,
    name:String,
    email:String,
    contact:String,
    city:String
}`
