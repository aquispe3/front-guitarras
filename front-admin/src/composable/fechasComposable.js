import moment from 'moment';
export function convertToDDMMYYYY(pFecha) {
    if (pFecha != null && pFecha != "" && pFecha!="0000-00-00")
      return moment(pFecha, "YYYY-MM-DDTHH:mm:ssZ").format("DD/MM/YYYY HH:mm");
    return "";
}