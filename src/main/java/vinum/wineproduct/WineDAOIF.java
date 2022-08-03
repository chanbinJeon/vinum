/**
 * 
 */
package vinum.wineproduct;

import java.sql.Connection;

/**
 * @author user
 *
 */
public interface WineDAOIF {
	public WineDAOIF getInstance();
	public void setConnection(Connection con);
	public String listWine();
	public long selectWine(long productnumber);
	public int insertWine(WineVO wineVO);
	public int updateWine(WineVO wineVO);
	public int deleteWine(WineVO wineVO);
}
