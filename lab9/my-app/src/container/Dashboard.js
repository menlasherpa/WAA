import React, { useEffect, useState } from "react";
import axios from 'axios';
import AddPost from "../components/AddPost";
import Post from "../components/Post";
import PostDetails from "../components/PostDetails";
import { SelectedIdContext } from "../store/selectedId";
import "../components/Posts.css"

const Dashboard = () => {
  const [posts, setPosts] = useState([]);
  const [selectedId, setSelectedId] = useState(null);
  const [flag, setFlag] = useState(false);
  const [unflag, setUnflag] = useState(false);

  const [selectedPost, setSelectedPost] = useState({
    title: "",
    author: "",
    content: "",
  });

  const flagHandler = () => {
    setFlag(!unflag);
  };

  const fetchPosts = () => {
    axios
      .get("https://localhost:8000/posts/")
      .then((res) => {
        setPosts([...res.data]);
      })
      .catch((err) => {
        console.error(err);
      });
  };

  useEffect(() => {
    fetchPosts();
  }, [flag]);

  useEffect(() => {
    axios.get(`https://localhost:8000/posts/${selectedId}`).then((res) => {
      setSelectedPost(res.data);
    });
  }, [selectedId]);

  const postSelectedHandler = (id) => {
    setSelectedId(id);
    setFlag(!flag);
  };

  const deleteHandler = () => {
    axios
      .delete(`https://localhost:8000/posts/${selectedId}`)
      .then((res) => {
        setPosts(posts.filter((p) => p.id != selectedId));
        setSelectedId(null);
      })
      .catch((err) => {
        console.error(err);
      });
  };

  const allPosts = posts.map((p) => {
    return (
      <Post
        key={p.id}
        title={p.title}
        author={p.author}
        clicked={() => {
          postSelectedHandler(p.id);
        }}
      />
    );
  });

  return (
    <React.Fragment>
      <SelectedIdContext.Provider value={selectedId}>
        <div class="allPost">{allPosts}</div>
        <div class="postDetails">
          <PostDetails
            id={selectedId}
            title={selectedPost.title}
            author={selectedPost.author}
            detail={selectedPost}
            deletePost={deleteHandler}
          />
        </div>
        <div class="addPost">
          <AddPost execute={flagHandler} />
        </div>
      </SelectedIdContext.Provider>
    </React.Fragment>
  );
};

export default Dashboard;
