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
