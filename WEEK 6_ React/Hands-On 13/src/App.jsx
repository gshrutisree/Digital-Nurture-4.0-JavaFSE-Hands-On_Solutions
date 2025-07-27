import React from "react";
import BookDetails from "./BookDetails";
import BlogDetails from "./BlogDetails";
import CourseDetails from "./CourseDetails";
import "./index.css";

function App() {
  return (
    <div className="container">
      <div className="box">
        <CourseDetails />
      </div>
      <div className="box green-border">
        <BookDetails />
      </div>
      <div className="box">
        <BlogDetails />
      </div>
    </div>
  );
}

export default App;
