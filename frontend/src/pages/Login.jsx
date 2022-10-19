import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import Header from '../components/Header';
import * as S from '../styles/login';

export default function Login() {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const VALID_USER = 'admin@admin.com';
  const VALID_PASS = 'admin123';

  const navigate = useNavigate();

  function validateLogin(email, password) {
    if (email !== VALID_USER || password !== VALID_PASS) {
      return false;
    }
    return true;
  }

  function handleClick() {
    if (!validateLogin(email, password)) {
      return window.alert('Login inválido');
    }
    navigate('/create');
  }

  return (
    <>
      <Header />
      <S.FormContainer>
        <S.Label htmlFor="email-input">
          Email
          <S.Input
            id="email-input"
            type="text"
            placeholder="user@user.com"
            value={ email }
            onChange={({ target }) => setEmail(target.value)}
          />
        </S.Label>
        <S.Label htmlFor="password-input">
          Senha
          <S.Input
            id="password-input"
            type="password"
            placeholder="********"
            value={ password }
            onChange={({ target }) => setPassword(target.value)}
          />
        </S.Label>
        <S.Button
          type="button"
          onClick={ handleClick }
        >
          Entrar
        </S.Button>
      </S.FormContainer>
    </>
  );
};
