import React from 'react';
import NavigationBar from '../components/NavigationBar';
import * as S from '../styles/createClient';

export default function CreateClient() {
  return (
    <>
      <NavigationBar />
      <S.FormContainer>
        <S.Label htmlFor="name">
          Nome
          <S.Input id="name" type="text" />
        </S.Label>
        <S.Label htmlFor="group">
          Grupo
          <S.Input id="group" type="text" />
        </S.Label>
        <S.Label>
          Status
          <S.Select>
            <option value="ativo">ativo</option>
            <option value="inativo">inativo</option>
          </S.Select>
        </S.Label>
        <S.Label>
          Tipo
          <S.Select>
            <option value="pf">pessoa física</option>
            <option value="pj">pessoa jurídica</option>
          </S.Select>
        </S.Label>
        <S.Label>
          cpf
          <S.Input type="text" maxLength="11" />
        </S.Label>
        <S.Label>
          RG
          <S.Input type="text" maxLength="10" />
        </S.Label>
      </S.FormContainer>
    </>
  );
};
