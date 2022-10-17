import styled from 'styled-components';

export const GroupContainer = styled.div`
  display: flex;
  justify-content: space-evenly;
  height: 80vh;
`;

export const CardContainer = styled.div`
  justify-content: center;
  border-radius: 0.5rem;
  box-shadow: 0 0 0.25rem 0.15rem #ccc;
  display: flex;
  flex-direction: column;
  height: 12.5rem;
  margin: 0.5rem 0;
`;

export const CardInfo = styled.span`
  display: flex;
  flex-direction: column;
  font-size: 1.5rem;
`;

export const ButtonContainer = styled.div`
  align-items: center;
  display: flex;
  flex-direction: column;
`;

export const Button = styled.button`
  background: #71A9F7;
  border: none;
  border-radius: 0.5rem;
  color: #fff;
  font-size: 1rem;
  height: 1.5rem;
  margin: 0.25rem 0;
  width: 10rem;

  &:hover {
    background: #0D68E7;
    cursor: pointer;
  }
`;
