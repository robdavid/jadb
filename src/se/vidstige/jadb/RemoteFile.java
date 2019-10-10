package se.vidstige.jadb;

/**
 * Created by vidstige on 2014-03-20
 */
public class RemoteFile {
    private final String path;

    public RemoteFile(String path) { this.path = path; }

    public String getName() { throw new UnsupportedOperationException(); }
    public int getSize() { throw new UnsupportedOperationException(); }
    public int getLastModified() { throw new UnsupportedOperationException(); }
    public int getMode() { throw new UnsupportedOperationException(); }

    public String getPath() { return path;}

    public int getTypeBits()     { return getMode() & 0170000; }
    public boolean isDirectory() { return getTypeBits() == 040000; }
    public boolean isLink()      { return getTypeBits() == 0140000; }
    public boolean isFile()      { return getTypeBits() == 0100000; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RemoteFile that = (RemoteFile) o;
        return path.equals(that.path);
    }

    @Override
    public int hashCode() {
        return path.hashCode();
    }
}
