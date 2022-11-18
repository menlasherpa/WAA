import React from "react";
import { ReactDOM } from "react";
import Posts from "./posts";
import { useEffect, useState } from "react";
import PostDetails from "../components/postDetails";
import axios from "axios";
import AddPost from "../components/AddPost";

const Dashboard = () => {
  const [posts, setPosts] = useState([
    { id: 1, title: "Happiness", author: "John" },
    { id: 2, title: "MIU", author: "Dean" },
    { id: 3, title: "Enjoy Life", author: "Jasmine" },
  ]);

  const [selected, setSelected] = useState(0);

  const [flag, setFlag] = useState(true);

  const [title, setTitle] = useState("");

  const fetchData = () => {
    axios
      .get("http://localhost:8000/posts/")
      .then((response) => {
        setPosts(response.data);
      })
      .catch((error) => {
        console.log(error.message);
      });
  };

  useEffect(() => {
    fetchData();
  }, [flag]);

  const updateFlag = () => {
    setFlag(!flag);
  };

  const setSelectedHandler = (id) => {
    setSelected(id);
    console.log(id);
  };

  const changeTitle = () => {
    posts[0].title = title;
    setPosts([...posts]);
  };

  const deleteHandler = (id) => {
    axios
      .delete("http://localhost:8000/posts/" + id)
      .then((response) => {
        fetchData();
        console.log(response.data);
      })
      .catch((error) => {
        console.log(error.message);
      });
  };

  return (
    <div>
      <div className="Post">
        <Posts data={posts} setSelected={setSelectedHandler} />
      </div>

      <div>
        <input
          type="text"
          id="text"
          title="title"
          onChange={(title) => setTitle(title.target.value)}
        />
        <br />
        <button className="button" onClick={changeTitle}>
          Change Title
        </button>
      </div>

      <div>
        <PostDetails
          id={selected}
          title={{ ...posts[selected - 1] }.title}
          author={{ ...posts[selected - 1] }.author}
          content={{ ...posts[selected - 1] }.content}
          deletePost={deleteHandler}
        />
      </div>
      <div>
        <AddPost
          id={posts.id}
          title={posts.title}
          author={posts.author}
          content={posts.content}
          updateFlag={updateFlag}
        />
      </div>
    </div>
  );
};

export default Dashboard;
