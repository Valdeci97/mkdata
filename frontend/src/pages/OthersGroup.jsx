import { useEffect, useState } from 'react';
import NavigationBar from '../components/NavigationBar';
import { GroupContainer } from '../styles/clientGroupCard';
import ClientGroupCard from '../components/ClientGroupCard';
import { setupClientsByClub } from '../utils/helpers';
import { getClientByClub } from '../utils/server';

export default function OthersGroup() {
  const [clients, setClients] = useState([]);

  useEffect(() => {
    setupClientsByClub('outros', getClientByClub, setClients);
  }, []);

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
