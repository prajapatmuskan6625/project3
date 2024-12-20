/*
 * package in.co.rays.project_3.controller;
 * 
 * import java.io.IOException; import java.util.HashMap;
 * 
 * import javax.servlet.ServletException; import
 * javax.servlet.annotation.WebServlet; import
 * javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse; import javax.xml.crypto.Data;
 * 
 * import in.co.rays.project_3.dto.BaseDTO; import
 * in.co.rays.project_3.dto.CartOverviewDTO; import
 * in.co.rays.project_3.exception.ApplicationException; import
 * in.co.rays.project_3.exception.DuplicateRecordException; import
 * in.co.rays.project_3.model.ModelFactory; import
 * in.co.rays.project_3.util.DataUtility; import
 * in.co.rays.project_3.util.DataValidator; import
 * in.co.rays.project_3.util.PropertyReader; import
 * in.co.rays.project_3.util.ServletUtility;
 * 
 * @WebServlet(name = "CartOverviewCtl", urlPatterns = { "/ctl/CartOverviewCtl"
 * })
 * 
 * public class CartOverviewCtl extends BaseCtl{
 * 
 * 
 * @Override protected void preload(HttpServletRequest request) {
 * 
 * HashMap map = new HashMap(); map.put("Computer", "Computer");
 * map.put("Laptop", "Laptop"); map.put("Mobile", "Mobile");
 * 
 * 
 * request.setAttribute("product", map);
 * 
 * 
 * 
 * }
 * 
 * protected boolean validate(HttpServletRequest request) { boolean pass = true;
 * 
 * if (DataValidator.isNull(request.getParameter("customerName"))) {
 * request.setAttribute("customerName", PropertyReader.getValue("error.require",
 * "customerName")); pass = false; } else if
 * (DataValidator.isTooLong(request.getParameter("name"),20)) {
 * request.setAttribute("customerName",
 * "customerName must contain max 20 charactor  "); pass = false; }
 * 
 * 
 * if (DataValidator.isNull(request.getParameter("transactionDate"))) {
 * request.setAttribute("transactionDate",
 * PropertyReader.getValue("error.require", "transactionDate")); pass = false; }
 * 
 * 
 * 
 * 
 * 
 * if (DataValidator.isNull(request.getParameter("quantityOrdered"))) {
 * request.setAttribute("quantityOrdered",
 * PropertyReader.getValue("error.require", "quantityOrdered")); pass = false; }
 * 
 * 
 * 
 * 
 * 
 * return pass;
 * 
 * }
 * 
 * protected BaseDTO populateDTO(HttpServletRequest request) { CartOverviewDTO
 * dto = new CartOverviewDTO();
 * 
 * 
 * dto.setId(DataUtility.getLong(request.getParameter("id")));
 * dto.setCustomerName(DataUtility.getString(request.getParameter("customerName"
 * ))); dto.setProduct(DataUtility.getString(request.getParameter("product")));
 * dto.setTransactionDate(DataUtility.getDate(request.getParameter(
 * "transactionDate")));
 * dto.setQuantityOrdered(DataUtility.getLong(request.getParameter(
 * "quantityOrdered")));
 * 
 * 
 * 
 * 
 * 
 * populateBean(dto, request);
 * 
 * return dto;
 * 
 * }
 * 
 * protected void doGet(HttpServletRequest request, HttpServletResponse
 * response) throws IOException, ServletException { String op =
 * DataUtility.getString(request.getParameter("operation"));
 * CartOverviewModelInt model =
 * ModelFactory.getInstance().getCartOverviewModel(); long id =
 * DataUtility.getLong(request.getParameter("id")); if (id > 0 || op != null) {
 * CartOverviewDTO dto; try { dto = model.findByPK(id);
 * ServletUtility.setDto(dto, request); } catch (Exception e) {
 * e.printStackTrace(); ServletUtility.handleException(e, request, response);
 * return; } } ServletUtility.forward(getView(), request, response); }
 * 
 * protected void doPost(HttpServletRequest request, HttpServletResponse
 * response) throws IOException, ServletException { String op =
 * DataUtility.getString(request.getParameter("operation"));
 * CartOverviewModelInt model =
 * ModelFactory.getInstance().getCartOverviewModel(); long id =
 * DataUtility.getLong(request.getParameter("id")); if
 * (OP_SAVE.equalsIgnoreCase(op) || OP_UPDATE.equalsIgnoreCase(op)) {
 * CartOverviewDTO dto = (CartOverviewDTO) populateDTO(request); try { if (id >
 * 0) { model.update(dto);
 * 
 * ServletUtility.setSuccessMessage("Data is successfully Update", request); }
 * else {
 * 
 * try { model.add(dto); ServletUtility.setDto(dto, request);
 * ServletUtility.setSuccessMessage("Data is successfully saved", request); }
 * catch (ApplicationException e) { ServletUtility.handleException(e, request,
 * response); return; } catch (DuplicateRecordException e) {
 * ServletUtility.setDto(dto, request);
 * ServletUtility.setErrorMessage("Login id already exists", request); }
 * 
 * } ServletUtility.setDto(dto, request);
 * 
 * } catch (ApplicationException e) { ServletUtility.handleException(e, request,
 * response); return; } catch (DuplicateRecordException e) {
 * ServletUtility.setDto(dto, request);
 * ServletUtility.setErrorMessage("Login id already exists", request); } } else
 * if (OP_DELETE.equalsIgnoreCase(op)) {
 * 
 * CartOverviewDTO dto = (CartOverviewDTO) populateDTO(request); try {
 * model.delete(dto); ServletUtility.redirect(ORSView.OWNER_LIST_CTL, request,
 * response); return; } catch (ApplicationException e) {
 * ServletUtility.handleException(e, request, response); return; }
 * 
 * } else if (OP_CANCEL.equalsIgnoreCase(op)) {
 * 
 * ServletUtility.redirect(ORSView.OWNER_LIST_CTL, request, response); return; }
 * else if (OP_RESET.equalsIgnoreCase(op)) {
 * 
 * ServletUtility.redirect(ORSView.OWNER_CTL, request, response); return; }
 * ServletUtility.forward(getView(), request, response);
 * 
 * }
 * 
 * @Override protected String getView() { // TODO Auto-generated method stub
 * return ORSView.OWNER_VIEW; }
 * 
 * }
 */