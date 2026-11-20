// Experience API: shapes the Tenant API results for the Sales Insights screen.
import { tenantClient } from '../../clients/tenantClient';

export async function getTopCities(startDate: string, endDate: string) {
  const rows = await tenantClient.get('/sales/top-cities', { params: { startDate, endDate } });
  return rows.data.map((r: [string, number]) => ({ city: r[0], revenue: r[1] }));
}

export async function getRevenueBySegment(startDate: string, endDate: string) {
  const rows = await tenantClient.get('/sales/revenue-by-segment', { params: { startDate, endDate } });
  return rows.data.map((r: [string, number, number]) => ({ segment: r[0], revenue: r[1], orders: r[2] }));
}
