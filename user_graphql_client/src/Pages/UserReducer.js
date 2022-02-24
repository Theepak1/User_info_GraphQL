import {FETCH_USERS_SUCCESS,} from "./ActionType";

const iniState = {
  users: [],
};

const reducer = (state = iniState, action) => {
  switch (action.type) {
    case FETCH_USERS_SUCCESS:
      return {
        ...state,
        users: action.payload,
      };

    default:
      return state;
  }
};
export default reducer;
