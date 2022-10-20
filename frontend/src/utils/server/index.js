import axios from 'axios';

const baseURL = 'http://mkadatachallenge-env.eba-bymdnusu.us-east-1.elasticbeanstalk.com/clients';

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
    return newClient.data;
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
    return newClient.data;
  } catch (err) {
    return null;
  }
}

export async function getClients() {
  try {
    const clients = await API.get();
    return clients.data;
  } catch (err) {
    return null;
  }
}

export async function getClientById(id) {
  if (!id) return false;
  try {
    const client = await API.get(`/${id}`);
    return client.data;
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

export async function getClientByClub(club) {
  if (!club) return false;
  try {
    const clients = await API.get(`/club/${club}`);
    return clients.data;
  } catch (err) {
    return null;
  }
}
