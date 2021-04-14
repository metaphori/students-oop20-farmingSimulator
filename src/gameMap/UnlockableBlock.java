package gameMap;

public interface UnlockableBlock {
	public boolean isLocked();
	public void unlockBlock();
	public void lockBlock();
}
