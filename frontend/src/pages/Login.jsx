import React from 'react';
import Header from '../components/Header';
import * as S from '../styles/login';

export default function Login() {
  return (
    <>
      <Header />
      <S.FormContainer>
        <S.Label htmlFor="email-input">
          Email:
          <S.Input
            id="email-input"
            type="text"
            placeholder="user@user.com"
          />
        </S.Label>
        <S.Label htmlFor="password-input">
          Senha:
          <S.Input
            id="password-input"
            type="password"
            placeholder="********"
          />
        </S.Label>
        <S.Button>Entrar</S.Button>
      </S.FormContainer>
    </>
  );
};
