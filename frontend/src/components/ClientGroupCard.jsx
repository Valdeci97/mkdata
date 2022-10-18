import { useNavigate } from 'react-router-dom';
import * as S from '../styles/clientGroupCard';
import { destroyClient } from '../utils/server';

export default function ClientGroupCard({ client }) {
  async function deleteClient(id) {
    await destroyClient(id);
    window.location.reload();
  }

  const navigate = useNavigate();

  function editClient(id) {
    const [, clientId] = id.split('-');
    navigate(`/clients/${clientId}`);
  }

  return (
    <>
      <S.CardContainer>
        <S.CardInfo>Nome: {`${client.name}`}</S.CardInfo>
        <S.CardInfo>Grupo: {`${client.club}`}</S.CardInfo>
        <S.CardInfo>Status: {`${client.status}`}</S.CardInfo>
        <S.CardInfo>Tipo: {`${client.type}`}</S.CardInfo>
        <S.CardInfo>Data de registro: {`${client.registerDate}`}</S.CardInfo>
        <S.ButtonContainer>
          <S.Button
            type="button"
            id={`edit-${client.id}`}
            onClick={({ target }) => editClient(target.id)}
          >
            Editar
          </S.Button>
          <S.Button
            type="button"
            id={ client.id }
            onClick={({ target }) => deleteClient(target.id)}
          >
            Excluir
          </S.Button>
        </S.ButtonContainer>
      </S.CardContainer>
    </>
  );
};
