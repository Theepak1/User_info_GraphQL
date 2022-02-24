import React from "react";
import UserListing from "./UserListing";
import { fetchUsersSuccess } from "./UserAction";
import { useQuery, gql } from "@apollo/client";
import { useDispatch } from "react-redux";


const GET_USERS = gql`
query fetchusers {
  users{
    id
    name
    email
  }
}
`;
export default function UserFetch() {
  const dispatch = useDispatch();
  const { error, data, loading } = useQuery(GET_USERS);
  console.log({ error, loading, data });
  if (loading) return <h1>Loading...</h1>;
  dispatch(fetchUsersSuccess(data));
  return (
    <div>
      <UserListing />
    </div>
  );
}
