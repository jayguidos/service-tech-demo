/*
* Created on 10/09/2016
* By bidsjagu
* ===========================================================================
*/

package com.strata.health.dto;

import java.io.Serializable;

public class DTOEntityKey
        implements Serializable
{
    private final String typeKey;
    private final int typeVersion;
    private final String id;

    public DTOEntityKey(String typeKey, int typeVersion, String id)
    {
        assert typeKey != null && typeKey.length() > 0;
        assert id != null && id.length() > 0;
        this.typeKey = typeKey;
        this.typeVersion = typeVersion;
        this.id = id;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof DTOEntityKey)) return false;

        DTOEntityKey that = (DTOEntityKey) o;

        if (typeVersion != that.typeVersion) return false;
        if (!typeKey.equals(that.typeKey)) return false;
        return id.equals(that.id);

    }

    @Override
    public int hashCode()
    {
        int result = typeKey.hashCode();
        result = 31 * result + typeVersion;
        result = 31 * result + id.hashCode();
        return result;
    }

    public String getTypeKey()
    {
        return typeKey;
    }

    public String getId()
    {
        return id;
    }

    public int getTypeVersion()
    {
        return typeVersion;
    }
}
