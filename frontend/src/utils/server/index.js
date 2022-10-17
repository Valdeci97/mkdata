import axios from 'axios';

const baseURL = 'http://localhost:8080/clients'

const API = axios.create({
  baseURL 
});

export async function createIndividualClient(client) {
  try {
    const newClient = await API.post('/pf', {
      name: client.name,
      club: client.club,
      status: client.status,
      type: client.type,
      cpf: client.cpf,
      rg: client.rg,
    });
    return newClient;
  } catch (err) {
    return null;
  }
}

export async function createCorporateClient(client) {
  try {
    const newClient = await API.post('/pj', {
      name: client.name,
      club: client.club,
      status: client.status,
      type: client.type,
      cnpj: client.cnpj,
      ie: client.ie,
    });
    return newClient;
  } catch (err) {
    return null;
  }
}

export async function getClients() {
  try {
    const clients = await API.get();
    return clients;
  } catch (err) {
    return null;
  }
}

export async function getClientById(id) {
  if (!id) return false;
  try {
    const client = await API.get(`/${id}`);
    return client;
  } catch (err) {
    return null;
  }
}

export async function destroyClient(id) {
  if (!id) return false;
  try {
    await API.delete(`/${id}`);
    return true;
  } catch (err) {
    return null;
  }
}

export async function updateIndividualClient(id, client) {
  if (!id) return false;
  try {
    const updatedClient = await API.put(`/pf/${id}`, {
      name: client.name,
      club: client.club,
      cpf: client.cpf,
      rg: client.rg,
      status: client.status,
    });
    return updatedClient;
  } catch (err) {
    return null;
  }
}

export async function updateCorporateClient(id, client) {
  if (!id) return false;
  try {
    const updatedClient = await API.put(`/pj/${id}`, {
      name: client.name,
      club: client.club,
      cnpj: client.cnpj,
      ie: client.ie,
      status: client.status,
    });
    return updatedClient;
  } catch (err) {
    return null;
  }
}

