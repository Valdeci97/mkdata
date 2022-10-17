import React from 'react';
import ClientGroupCard from '../components/ClientGroupCard';
import NavigationBar from '../components/NavigationBar';
import { clients } from '../utils/mock/clients';
import { GroupContainer } from '../styles/clientGroupCard';

export default function HealthGroup() {
  return (
    <>
      <NavigationBar />
      <GroupContainer>
        {
          clients.map((client) => {
            return <ClientGroupCard key={`client-${client.id}`} client={client} />
          })
        }
      </GroupContainer>
    </>
  );
};
