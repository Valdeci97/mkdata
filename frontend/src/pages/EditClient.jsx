import { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import NavigationBar from '../components/NavigationBar';
import { handlePfInput } from '../utils/helpers';
import * as S from '../styles/handleClient';
import {
  getClientById,
  updateIndividualClient,
  updateCorporateClient,
} from '../utils/server';

export default function EditClient() {
  const [name, setName] = useState('');
  const [group, setGroup] = useState('');
  const [status, setStatus] = useState('');
  const [cpf, setCpf] = useState('');
  const [rg, setRg] = useState('');
  const [cnpj, setCnpj] = useState('');
  const [ie, setIe] = useState('');
  const [isPf, setIsPf] = useState(true);
  const [id, setId] = useState('');

  const navigate = useNavigate();

  async function handleURL(url) {
    const [, , id] = url.split('/');
    const client = await getClientById(id);
    if (!client) return;
    setId(id);
    setName(client.name);
    setGroup(client.club);
    setStatus(client.status);
    setIsPf(client.type === 'pf');
    if (client.type === 'pf') {
      setCpf(client.cpf);
      setRg(client.rg);
      return;
    }
    setCnpj(client.cnpj);
    setIe(client.ie);
  }

  const handleClick = async () => {
    if (isPf) {
      const client = { name, club: group, cpf, rg, status };
      const result = await updateIndividualClient(id, client);
      if (!result) return window.alert('Não foi possível atualizar');
      return navigate('/clients');
    }
    const client = { name, club: group, cnpj, ie, status };
    const result = await updateCorporateClient(id, client);
    if (!result) return window.alert('Não foi possível atualizar');
    navigate('/clients');
  }

  useEffect(() => {
    handleURL(window.location.pathname);
  }, [])

  return (
    <>
      <NavigationBar />
      <S.FormContainer>
        <S.Label htmlFor="client-name">
          Nome
          <S.Input
            id="client-name"
            value={ name }
            onChange={(({ target }) => setName(target.value))}
          />
        </S.Label>
        <S.Label htmlFor="client-group">
          Grupo
          <S.Select
            id="client-group"
            value={ group }
            onChange={({ target }) => setGroup(target.value)}
          >
            <option value="saúde">saúde</option>
            <option value="tech">tecnologia inf</option>
            <option value="financeiro">financeiro</option>
            <option value="outros">outros</option>
          </S.Select>
        </S.Label>
        <S.Label htmlFor="client-status">
          Status
          <S.Select
            id="client-status"
            value={ status }
            onChange={({ target }) => setStatus(target.value)}
          >
            <option value="ativo">ativo</option>
            <option value="inativo">inativo</option>
          </S.Select>
        </S.Label>
        <S.Label htmlFor="client-specific-info">
          { isPf ? 'cpf' : 'cnpj' }
          <S.Input
            id="client-specific-info"
            value={ isPf ? cpf : cnpj }
            type="text"
            maxLength={ isPf ? 11 : 14 }
            onChange={({ target }) => handlePfInput(isPf, target.value, setCpf, setCnpj)}
          />
        </S.Label>
        <S.Label htmlFor="client-specific-info-2">
          { isPf ? 'RG' : 'IE' }
          <S.Input
            id="client-specific-info-2"
            value={ isPf ? rg : ie }
            type="text"
            maxLength="9"
            onChange={({ target }) => handlePfInput(isPf, target.value, setRg, setIe)}
          />
        </S.Label>
        <S.Button type="button" onClick={ handleClick }>
          Finalizar
        </S.Button>
      </S.FormContainer>
    </>
  );
};
