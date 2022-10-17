import React from 'react';
import { Routes, Route, Navigate } from 'react-router-dom';
import CreateClient from './pages/CreateClient';
import Login from './pages/Login';

export default function Router() {
  return (
    <Routes>
      <Route path="/" element={ <Navigate to="/login" replace /> } />
      <Route path="/login" element={ <Login /> } />
      <Route path="/create" element={ <CreateClient /> } />
    </Routes>
  );
};
