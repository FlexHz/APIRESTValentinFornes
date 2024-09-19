package valentinIT.APIREST_ValentinFornes.config;

import org.hibernate.envers.RevisionListener;
import valentinIT.APIREST_ValentinFornes.audit.Revision;

public class CRL implements RevisionListener {

    public void newRevision(Object revisionEntity) {
        final Revision revision = (Revision) revisionEntity;
    }

}
