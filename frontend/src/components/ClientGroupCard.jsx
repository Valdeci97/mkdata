import React from 'react';
import * as S from '../styles/clientGroupCard';

export default function ClientGroupCard({ client }) {
  return (
    <>
      <S.CardContainer>
        <S.CardInfo>Nome: {`${client.name}`}</S.CardInfo>
        <S.CardInfo>Grupo: {`${client.club}`}</S.CardInfo>
        <S.CardInfo>Status: {`${client.status}`}</S.CardInfo>
        <S.CardInfo>Tipo: {`${client.type}`}</S.CardInfo>
        <S.CardInfo>Data de registro: {`${client.registerDate}`}</S.CardInfo>
        <S.ButtonContainer>
          <S.Button type="button">Editar</S.Button>
          <S.Button type="button">Excluir</S.Button>
        </S.ButtonContainer>
      </S.CardContainer>
    </>
  );
};
