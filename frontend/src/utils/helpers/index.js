export async function setupClientsByClub(club, firstFunc, secondFunc) {
  const clients = await firstFunc(club);
  if (!clients) return [];
  secondFunc(clients);
}