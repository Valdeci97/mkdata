import { useState } from 'react';
import NavigationBar from '../components/NavigationBar';
import * as S from '../styles/handleClient';
import { createIndividualClient, createCorporateClient } from '../utils/server';
import { handlePfInput } from '../utils/helpers';
import { useNavigate } from 'react-router-dom';

export default function CreateClient() {
  const [name, setName] = useState('');
  const [group, setGroup] = useState('saúde');
  const [status, setStatus] = useState('ativo');
  const [type, setType] = useState('pf');
  const [cpf, setCpf] = useState('');
  const [rg, setRg] = useState('');
  const [isPf, setIsPf] = useState(true);
  const [cnpj, setCpnj] = useState('');
  const [ie, setIe] = useState('');

  const navigate = useNavigate();

  const handlePfState = (firstFunc, secondFunc, thirdFunc, fourthFunc) => {
    if (isPf) {
      firstFunc('');
      secondFunc('');
      return;
    }
    thirdFunc('');
    fourthFunc('');
  }

  const handlePf = (value) => {
    setType(value);
    setIsPf(value === 'pf');
    handlePfState(setCpf, setRg, setCpnj, setIe);
  }

  const handleClick = async () => {
    if (type === 'pf') {
      const client = { name, club: group, status, type, cpf, rg };
      const newClient = await createIndividualClient(client);
      if (!newClient) return window.alert('Não foi possível criar');
      return navigate('/clients');
    }
    const client = { name, club: group, status, type, cnpj, ie };
    const newClient = await createCorporateClient(client);
    if (!newClient) return window.alert('Não foi possível criar');
    navigate('/clients');
  }

  return (
    <>
      <NavigationBar />
      <S.FormContainer>
        <S.Label htmlFor="name">
          Nome
          <S.Input
            id="name"
            type="text"
            value={ name }
            onChange={({ target }) => setName(target.value)}
          />
        </S.Label>
        <S.Label htmlFor="group">
          Grupo
          <S.Select
            id="group"
            value={ group }
            onChange={({ target }) => setGroup(target.value)}
          >
            <option value="saúde">saúde</option>
            <option value="tech">tecnologia inf</option>
            <option value="financeiro">financeiro</option>
            <option value="outros">outros</option>
          </S.Select>
        </S.Label>
        <S.Label htmlFor="status">
          Status
          <S.Select
            id="status"
            value={ status }
            onChange={({ target }) => setStatus(target.value)}
          >
            <option value="ativo">ativo</option>
            <option value="inativo">inativo</option>
          </S.Select>
        </S.Label>
        <S.Label htmlFor="type">
          Tipo
          <S.Select
            id="type"
            value={ type }
            onChange={({ target }) => handlePf(target.value)}
          >
            <option value="pf">pessoa física</option>
            <option value="pj">pessoa jurídica</option>
          </S.Select>
        </S.Label>
        <S.Label htmlFor="specific-input">
          { isPf ? 'cpf' : 'cpnj' }
          <S.Input
            id="specific-input"
            type="text"
            maxLength={ isPf ? 11 : 14 }
            value={ isPf ? cpf : cnpj }
            onChange={({ target }) => handlePfInput(isPf, target.value, setCpf, setCpnj)}
          />
        </S.Label>
        <S.Label htmlFor="specific-input-2">
          { isPf ? 'RG' : 'IE' }
          <S.Input
            id="specific-input-2"
            type="text"
            maxLength="9"
            value={ isPf ? rg : ie }
            onChange={({ target }) => handlePfInput(isPf, target.value, setRg, setIe)}
          />
        </S.Label>
        <S.Button type="button" onClick={ handleClick }>
          Criar
        </S.Button>
      </S.FormContainer>
    </>
  );
};
