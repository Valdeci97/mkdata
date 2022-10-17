import React from 'react';
import * as S from '../styles/navigation';

export default function NavigationBar() {
  return (
    <>
      <S.NavContainer>
        <S.Link href="/create">Criar cliente</S.Link>
        <S.Link href="/clients">Ver clientes</S.Link>
        <S.Link href="/health">Saúde</S.Link>
        <S.Link href="/tech">TI</S.Link>
        <S.Link href="/finance">Financeiro</S.Link>
        <S.Link href="/others">Outros</S.Link>
      </S.NavContainer>
    </>
  );
};
