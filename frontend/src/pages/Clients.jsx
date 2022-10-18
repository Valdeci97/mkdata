import { useEffect, useState } from 'react';
import NavigationBar from '../components/NavigationBar';
import ClientGroupCard from '../components/ClientGroupCard';
import { getClients } from '../utils/server';
import { GroupContainer } from '../styles/clientGroupCard';

export default function Clients() {
  const [clients, setClients] = useState([]);

  const setupClients = async () => {
    const result = await getClients();
    if (!result) return;
    setClients(result);
  }

  useEffect(() => {
    setupClients();
  }, [])

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
