import { useEffect, useState } from 'react';
import ClientGroupCard from '../components/ClientGroupCard';
import NavigationBar from '../components/NavigationBar';
import { GroupContainer } from '../styles/clientGroupCard';
import { setupClientsByClub } from '../utils/helpers';
import { getClientByClub } from '../utils/server';

export default function HealthGroup() {
  const [clients, setClients] = useState([]);

  useEffect(() => {
    setupClientsByClub('saúde', getClientByClub, setClients);
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
