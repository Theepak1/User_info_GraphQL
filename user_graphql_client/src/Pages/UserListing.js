import React, { useEffect } from "react";
import { useSelector} from "react-redux";
import { useState } from "react";


export default function UserListing() {

  const userData = useSelector((state) => state.users);
  const [users, setUser] = useState(userData);
  console.log(users);


  const deleted = (id) => {
    console.log(users);
    setUser(
      users.users.filter((user) => {
        return user.id !== id;
      })
    );
  };

  function edit(key) {
    const newData = {
      id: key,
      name: "theepak",
      email: "theepak@gmail.com",
    };
    setUser(
      users.users.map((user) => {
        if (user.id == key) {
          return newData;
        } else {
          return user;
        }
      })
    );
  }

  return (
    <div>
      <table
        border="1"
        bgcolor="white"
        class="table  table-bordered table-hover"
        align="center"
        width="70%"
        height="70%"
      >
        <tr>
          <th align="center"> ID</th>
          <th align="center">NAME </th>
          <th align="center">EMAIL </th>
          <th align="center">EDIT </th>
          <th align="center">DELETE </th>
        </tr>
        {users.users.map((user) => {
          return (
            <tr key={user.id}>
              <td align="center">{user.id}</td>
              <td align="center">{user.name}</td>
              <td align="center">{user.email}</td>
              <td align="center">
                <button style={style} onClick={() => edit(user.id)}>
                  {" "}
                  EDIT
                </button>
              </td>
              <td align="center">
                <button style={style} onClick={() => deleted(user.id)}>
                  DELETE
                </button>
              </td>
            </tr>
          );
        })}
      </table>
    </div>
  );
}
const style = {
  background: "linear-gradient(45deg, #FE6B8B 30%, #FF8E53 90%)",
  borderRadius: 3,
  border: 0,
  color: "white",
  height: 48,
  padding: "0 30px",
  boxShadow: "0 3px 5px 2px rgba(255, 105, 135, .3)",
  marginLeft: "10px",
};
