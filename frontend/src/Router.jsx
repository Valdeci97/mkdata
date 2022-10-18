import React from 'react';
import { Routes, Route, Navigate } from 'react-router-dom';
import Clients from './pages/Clients';
import CreateClient from './pages/CreateClient';
import EditClient from './pages/EditClient';
import FinanceGroup from './pages/FinanceGroup';
import HealthGroup from './pages/HealthGroup';
import Login from './pages/Login';
import OthersGroup from './pages/OthersGroup';
import TechGroup from './pages/TechGroup';

export default function Router() {
  return (
    <Routes>
      <Route path="/" element={ <Navigate to="/login" replace /> } />
      <Route path="/login" element={ <Login /> } />
      <Route path="/create" element={ <CreateClient /> } />
      <Route path="/health" element={ <HealthGroup /> } />
      <Route path="/clients" element={ <Clients /> } />
      <Route path="/tech" element={ <TechGroup /> } />
      <Route path="/finance" element={ <FinanceGroup /> } />
      <Route path="/others" element={ <OthersGroup /> } />
      <Route path="/clients/:id" element={ <EditClient /> } />
    </Routes>
  );
};
