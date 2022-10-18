export async function setupClientsByClub(club, firstFunc, secondFunc) {
  const clients = await firstFunc(club);
  if (!clients) return [];
  secondFunc(clients);
}

export const handlePfInput = (condition, value, firstFunc, secondFunc) => {
    if (condition) {
      firstFunc(value);
      return;
    }
    secondFunc(value);
  }