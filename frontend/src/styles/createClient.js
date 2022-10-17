import styled from 'styled-components';

export const FormContainer = styled.form`
  align-items: center;
  display: flex;
  flex-direction: column;
  justify-content: center;
  height: 80vh;
`;

export const Label = styled.label`
  align-items: center;
  display: flex;
  flex-direction: column;
  margin: 0.5rem 0;
`;

export const Input = styled.input`
  border: solid 1px #000;
  border-radius: 0.25rem;
  height: 1.75rem;
  margin: 0.25rem 0;
  text-align: center;
  width: 10rem;
`;

export const Select = styled.select`
  background: transparent;
  border-radius: 0.25rem;
  height: 1.75rem;
  margin: 0.25rem 0;
  text-align: center;
  width: 10rem;
`;

export const CreateClientButton = styled.button`
  background: #71A9F7;
  border: none;
  border-radius: 0.5rem;
  color: #fff;
  font-size: 1.25rem;
  height: 2rem;
  width: 8rem;

  &:hover {
    background: #0D68E7;
    cursor: pointer;
    height: 2.25rem;
    transition: all ease 0.5s;
    width: 10rem;
  }
`;
