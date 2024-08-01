import React from 'react';
import { Container, Col, Row } from 'reactstrap';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Header from './components/Header';
import Menus from './components/Menus';
import Home from './components/Home';
import AddCourse from './components/Addcourse'; 
import AllCourses from './components/Allcourses'; 
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

function App() {
  return (
    <div>
      <Router>
        <Container>
          <Header />
          <Row>
            <Col md={4}>
              <Menus />
            </Col>
            <Col md={8}>
              <Routes>
                <Route path="/" element={<Home />} exact={true} />
                <Route path="/add-course" element={<AddCourse />} exact={true} />
                <Route path="/view-course" element={<AllCourses />} exact={true} />
                <Route path="/about-course" element={<AllCourses />} exact={true} />
                <Route path="/contact" element={<AllCourses />} exact={true} />
              </Routes>
            </Col>
          </Row>
        </Container>
      </Router>
      <ToastContainer /> 
    </div>
  );
}

export default App;
