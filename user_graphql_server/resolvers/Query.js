module.exports = {
    users: (parent, args, { dataSources }, info) => {
      return dataSources.UserAPI.getUsers(args);
    },
};