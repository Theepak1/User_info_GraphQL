const {RESTDataSource} = require('apollo-datasource-rest');

class UserAPI extends RESTDataSource {
    constructor(){
        super();
        this.baseURL='http://localhost:9191/uis';
    }

    async getUsers(){
        const data = await this.get(`/getAllUsers`);
        return data;
    }
}

module.exports = UserAPI;