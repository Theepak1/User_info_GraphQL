import {FETCH_USERS_SUCCESS} from "./ActionType";

export const fetchUsersSuccess = (users) => {
    console.log("fetchusersuccess called",users);
  return {
    type: FETCH_USERS_SUCCESS,
    payload: users,
  };
};


